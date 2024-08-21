package io.github.flmaria.java_007.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Path path = Paths.get("example.txt");
        System.out.println("File Name: " + path.getFileName());
        System.out.println("Parent Directory: " + path.getParent());

        //---

        Path source = Paths.get("source.txt");
        Path target = Paths.get("target.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        //---

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("myDirectory"))) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //---

        Path path2 = Paths.get("example.txt");
        BasicFileAttributes attrs = Files.readAttributes(path2, BasicFileAttributes.class);
        System.out.println("Creation Time: " + attrs.creationTime());

        //---

        Path link = Paths.get("symbolicLink.txt");
        Path target2 = Paths.get("targetFile.txt");
        Files.createSymbolicLink(link, target2);

        //----

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path3 = Paths.get("myDirectory");
        path3.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
            }
            key.reset();
        }

        //----
        Path path4 = Paths.get("example.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path4, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                System.out.println("Read bytes: " + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });



    }

}
