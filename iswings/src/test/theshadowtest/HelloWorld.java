package test.theshadowtest;


public class HelloWorld {
//	public static void main(String[] args) {
//		GSpeechDuplex dup = new GSpeechDuplex(
//				"AIzaSyB70YpnyCGoOIwCn7kY_UX4M7nqVFB6xt0");// Instantiate the
//															// API
//		dup.addResponseListener(new GSpeechResponseListener() {// Adds the
//																// listener
//			public void onResponse(GoogleResponse gr) {
//				System.out.println(gr.getResponse());
////				System.out.println("with "
////						+ ((gr.getConfidence() != null) ? (Double
////								.parseDouble(gr.getConfidence()) * 100) : null)
////						+ "% confidence.");
//				System.out
//						.println("Google also thinks that you might have said:"
//								+ gr.getOtherPossibleResponses());
//			}
//		});
//		Microphone mic = new Microphone(FLACFileWriter.FLAC);// Instantiate
//																// microphone
//																// and have
//		// it record FLAC file.
//		
//													// buffer to.
//		// You can also create your own buffer using the getTargetDataLine()
//		// method.
//		while (true) {
//			try {
////				File file = new File("CRAudioTest.flac");// The File to record the
//				File file = File.createTempFile("chandu", Calendar.getInstance().getTimeInMillis()+"");
//				mic.captureAudioToFile(file);// Begins recording				
//				Thread.sleep(2000);// Records for 10 seconds
//				mic.close();// Stops recording
//				// Sends 10 second voice recording to Google
//				Path p = Paths.get(mic.getAudioFile().toURI());
//				byte[] data = Files.readAllBytes(p);// Saves data into
//																// memory.
//				dup.recognize(data, (int) mic.getAudioFormat().getSampleRate());
//				mic.getAudioFile().delete();// Deletes Buffer file
//				// REPEAT
//			} catch (Exception ex) {
//				ex.printStackTrace();// Prints an error if something goes wrong.
//			}
//		}
//	}
}
