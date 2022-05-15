package com.jzh.java.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @version 1.0
 * @description
 * @Author Jiang Zhihang
 * @Date 2022/5/10 0:17
 */
public class NIOTest {
    @Test
    public void test1() {
        String str = "abcde";

        //分配一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("---------allocate-----------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //1024
        System.out.println(byteBuffer.position());   //0

        //利用 put() 存入数据到缓冲区中
        byteBuffer.put(str.getBytes());
        System.out.println("---------put-----------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //1024
        System.out.println(byteBuffer.position());   //5

        //切换到读数据模式
        byteBuffer.flip();
        System.out.println("---------flip-----------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //5,limit 表示可以操作数据的大小,只有 5 个字节的数据给你读,所以可操作数据大小是 5
        System.out.println(byteBuffer.position());   //0,读数据要从第 0 个位置开始读

        //利用 get() 读取缓冲区中的数据
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println("---------get-----------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //5,可以读取数据的大小依然是 5 个
        System.out.println(byteBuffer.position());   //5,读完之后位置变到了第 5 个

        //rewind() 可重复读
        byteBuffer.rewind();         //这个方法调用完后,又变成了读模式
        System.out.println("---------rewind-----------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //5
        System.out.println(byteBuffer.position());  //0

        //clear() 清空缓冲区,虽然缓冲区被清空了，但是缓冲区中的数据依然存在，只是出于"被遗忘"状态。意思其实是，缓冲区中的界限、位置等信息都被置为最初的状态了，所以你无法再根据这些信息找到原来的数据了，原来数据就出于"被遗忘"状态
        byteBuffer.clear();
        System.out.println("---------clear-----------");
        System.out.println(byteBuffer.capacity());   //1024
        System.out.println(byteBuffer.limit());      //1024
        System.out.println(byteBuffer.position());  //0
    }

    @Test
    public void test2() {
        String str = "abcde";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        byte[] bytearray = new byte[byteBuffer.limit()];
        byteBuffer.get(bytearray, 0, 2);
        System.out.println(new String(bytearray, 0, 2));  //结果是 ab
        System.out.println(byteBuffer.position());   //结果是 2
        //标记一下当前 position 的位置
        byteBuffer.mark();
        byteBuffer.get(bytearray, 2, 2);
        System.out.println(new String(bytearray, 2, 2));
        System.out.println(byteBuffer.position());   //结果是 4
        //reset() 恢复到 mark 的位置
        byteBuffer.reset();
        System.out.println(byteBuffer.position());   //结果是 2

        //判断缓冲区中是否还有剩余数据
        if (byteBuffer.hasRemaining()) {
            //获取缓冲区中可以操作的数量
            System.out.println(byteBuffer.remaining());  //结果是 3,上面 position 是从 2 开始的
        }
    }

    @Test
    public void test3() {
        // 分配直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        // 判断是直接缓冲区还是非直接缓冲区
        System.out.println(byteBuffer.isDirect());
    }

    /**
     * @description: 使用通道完成文件的复制（非直接缓冲区）
     * @author Jiang Zhihang
     * @date 2022/5/11 0:03
     */
    @Test
    public void test4() throws IOException {
        FileInputStream fis = new FileInputStream("input.txt");
        FileOutputStream fos = new FileOutputStream("output.txt");
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fisChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fosChannel.close();
        fisChannel.close();
        fos.close();
        fis.close();
    }

    /**
     * @description: 使用直接缓冲区完成文件的复制（内存映射文件）
     * @author Jiang Zhihang
     * @date 2022/5/11 0:03
     */
    @Test
    public void test5() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("input.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("output.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        // 内存映射文件
        MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inMapped.limit()];
        inMapped.get(dst);
        outMapped.put(dst);
        inChannel.close();
        outChannel.close();
    }

    /**
     * @description: 使用直接缓冲区完成文件的复制（内存映射文件） 的另一种方法
     * @author Jiang Zhihang
     * @date 2022/5/11 0:03
     */
    @Test
    public void test6() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("input.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("output.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        // 或者可以使用下面这种方式
        //outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    @Test
    public void test7() throws IOException{
        RandomAccessFile raf = new RandomAccessFile("input.txt", "rw");
        // 获取通道
        FileChannel channel = raf.getChannel();
        // 分配指定大小缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(2);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        // 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel.read(bufs);  // 参数需要一个数组
        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();  // 切换到读模式
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));  // 打印 he
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));  // 打印 llo

        // 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("output.txt","rw");
        // 获取通道
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);  // 把 bufs 里面的几个缓冲区聚集到 channel2 这个通道中，聚集到通道中，也就是到了 e.txt 文件中
        channel2.close();
        raf.close();
        raf2.close();
    }
}
