package etude.single;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;

import java.io.FileInputStream;

/**
 * copié le 12/06/2017
 *
 * de : https://github.com/javaparser/javaparser/wiki/Manual
 *
 */
public class CuPrinter {

    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("E:\\dev\\IdeaProjects\\xslt-java\\src\\main\\java\\etude\\single\\Main.java");

        // parse the file
        CompilationUnit cu = JavaParser.parse(in);
        for (NodeList nl : cu.getNodeLists()) {
            for(int i=0;i<nl.size();i++) {
                System.out.println(i + " " + nl.get(i).toString());
            }
        };
        // prints the resulting compilation unit to default system output
        //System.out.println(cu.toString());
    }
}
