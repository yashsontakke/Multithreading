package LLD.compositedesignpattern;

import java.util.ArrayList;
import java.util.List;

interface FileSystem{
    void showDetail();
}

class File implements  FileSystem{
    String name ;
    File(String name){
        this.name = name ;
    }

    @Override
    public void showDetail() {
        System.out.println(name);
    }
}

class Folder implements FileSystem{

    String name ;
    List<FileSystem> children = new ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    public  void add(FileSystem fileSystem){
        children.add(fileSystem);
    }

    @Override
    public void showDetail() {
        System.out.println(this.name);
        for(FileSystem child: children){
            child.showDetail();
        }
    }
}

public class CompositePatternExample {

    public static void main(String[] args) {

        Folder folder1 = new Folder("Blockbuster Movies");
        File file1 = new File("-Sultan");
        File file2 = new File("-BB");

        folder1.add(file1);
        folder1.add(file2);

        Folder folder2 = new Folder("Comedy Movies");
        File file3 = new File("-NO Entry");
        File file4 = new File("-Ready");
        File file5 = new File("-Partner");

        folder2.add(file3);
        folder2.add(file4);
        folder2.add(file5);

        folder2.add(new File("no entry 2 is not happening "));

        Folder folder3 = new Folder("Movies");
        folder3.add(folder1);
        folder3.add(folder2);

        folder3.showDetail();

    }

}
