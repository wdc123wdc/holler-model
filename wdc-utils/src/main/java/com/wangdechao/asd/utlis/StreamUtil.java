package com.wangdechao.asd.utlis;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.LinkedList;

public class StreamUtil {

	public static void main(String[] args) {
	    FileInputStream fin = null; // Streams to the two files.
	    FileOutputStream fout = null; // These are closed in the finally block.
	    try {
	      // Open a stream to for the input file and get a channel from it
	      fin = new FileInputStream(args[0]);
	      FileChannel in = fin.getChannel();

	      // Now get the output channel
	      WritableByteChannel out;
	      if (args.length > 1) { // If there is a second filename
	        fout = new FileOutputStream(args[1]); // open file stream
	        out = fout.getChannel(); // get its channel
	      } else { // There is no destination filename
	        out = Channels.newChannel(System.out); // wrap stdout stream
	      }

	      // Query the size of the input file
	      long numbytes = in.size();

	      // Bulk-transfer all bytes from one channel to the other.
	      // This is a special feature of FileChannel channels.
	      // See also FileChannel.transferFrom()
	      in.transferTo(0, numbytes, out);
	    } catch (IOException e) {
	      // IOExceptions usually have useful informative messages.
	      // Display the message if anything goes wrong.
	      System.out.println(e);
	    } finally {
	      // Always close input and output streams. Doing this closes
	      // the channels associated with them as well.
	      try {
	        if (fin != null)
	          fin.close();
	        if (fout != null)
	          fout.close();
	      } catch (IOException e) {
	      }
	    }
	  }
	
	public static void main1(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/LoadTest.java"));
        String str;
        LinkedList<String> ls=new LinkedList<String>();
        while ((str = in.readLine()) != null) {
           ls.addFirst(str+"\n");
        }
        in.close();
        
    }
	
	 public static void main2(String[] args) throws IOException
	 {
	  FileReader fr = new FileReader("ming.txt");
	  char[] buffer = new char[1024];
	  int ch = 0;
	  while((ch = fr.read())!=-1 )
	  {
	   System.out.print((char)ch); 
	  }
	  
	  InputStreamReader isr = new InputStreamReader(new FileInputStream("ming.txt"));
	  while((ch = isr.read())!=-1)
	  {
	   System.out.print((char)ch); 
	  } 
	  
	  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ming.txt")));
	  String data = null;
	  while((data = br.readLine())!=null)
	  {
	   System.out.println(data); 
	  }
	  
	  FileWriter fw = new FileWriter("hello.txt");
	  String s = "hello world";
	  fw.write(s,0,s.length());
	  fw.flush();
	  
	  OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("hello2.txt"));
	  osw.write(s,0,s.length());
	  osw.flush();
	  
	  PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("hello3.txt")),true);
	  pw.println(s);
	  
	  fr.close();
	  isr.close();
	  br.close();
	  fw.close();
	  osw.close();
	  pw.close();
	 }
	
}
