package falbuquerque.study.ws.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLMarshaller {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        new XMLMarshaller().run();
    }

    void run() throws JAXBException, FileNotFoundException {
        final JAXBContext context = JAXBContext.newInstance(Skier.class);
        final File skiersFile = new File("/d:/dev/tmp/skier.xml");

        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        marshaller.marshal(createSkier(), new FileOutputStream(skiersFile));

        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final Skier unmarshalledSkier = (Skier) unmarshaller.unmarshal(skiersFile);
        marshaller.marshal(unmarshalledSkier, System.out);
    }

    private Skier createSkier() {
        return new Skier(new Person("John", "Male", (short) 30), "USA", Arrays.asList("12 Olympic Medals",
                "9 World Championships"));
    }

}
