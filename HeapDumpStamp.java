import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Date;

public class HeapDumpStamp {

    public static void main(String[] args) throws IOException {
	String fileName = args[0];
	DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName));

	// Read in JAVA PROFILE version. It's null terminated string.
	String version = "";
	byte inByte = inputStream.readByte();
	while (inByte != 0x00) {
	    version += ((char)inByte);
	    inByte = inputStream.readByte();
	}

	System.out.println(version);

	// Move on to time stamp.
	inputStream.readInt();

	long epoch = inputStream.readLong();
	System.out.println("Epoch Time: " + epoch);
	System.out.println("Date      : " + (new Date(epoch)));
	
    }
}
