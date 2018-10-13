package CamHacks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

public class TextToSpeech {
	public static void main(String []args){
		try {
			String arr = Base64.encodeBase64URLSafeString(FileUtils.readFileToByteArray(new File("ddd")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
