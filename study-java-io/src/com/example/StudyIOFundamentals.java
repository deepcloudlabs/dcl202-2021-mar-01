package com.example;

public class StudyIOFundamentals {

	public static void main(String[] args) {
		// Text IO vs Binary IO
		int x = 108; // 12345 // 3
		// x ->      memory -> file
		//             4B        ?
		// Text IO   -> char[]  108 (3B), 12345 (5B), 3 (1B) -> Text Editor: JSON, XML, CSV, SVG, ... -> HRF
		// Binary IO -> byte[]  108 (4B), 12345 (4B), 3 (4B) -> A2A, JPEG, DICOM, MP4, ..
        int [] numbers = {4, 8, 15, 16, 23, 42};
        // Text IO -> 4,8,15,16,23,42 (15B) -> 4 ? 48 ? 481 ? 4815 ? 48151 ... 
        // Binary IO -> 6 * 4B = 24B -> Random Access
        // Java IO -> Classes
	}

}
