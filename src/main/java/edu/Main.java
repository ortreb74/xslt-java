package edu;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.Configuration;

import net.sf.saxon.s9api.*;

import org.w3c.dom.Document;

import java.io.File;

/**
 * Created by ext-pdonzel on 31/05/2017.
 */
public class Main {

    public static void main(String args[]) throws SaxonApiException {
        Configuration config = Configuration.newConfiguration();
        //config.setURIResolver(...);
        Processor proc = new Processor(config);

        DocumentBuilder builder = proc.newDocumentBuilder();
        XsltCompiler compiler = proc.newXsltCompiler();

        XdmAtomicValue v = new XdmAtomicValue("un texte");
        compiler.setParameter(new QName("text"),v);

        XsltExecutable exec = compiler.compile(new StreamSource(args[0]));

        XsltTransformer transformer = exec.load();

        XdmNode node = builder.build(new StreamSource(args[0]));
        transformer.setInitialContextNode(node);

        Serializer out = new Serializer(System.out);
        transformer.setDestination(out);

        transformer.transform();

    }
}
