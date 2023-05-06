package edu.vtc.cis2271;

public class P8_9 
{
	 private String _from;
	 private String _to;
	 private String _text;

	    public P8_9(String from, String to) {
	        this._from = from;
	        this._to = to;
	        this._text = "";
	    }

	    public void addLine(String line) {
	        this._text += String.format("%s\n", line);
	    }
	    
	    public String getText() {
	        return String.format("\nDear %s\n\n%s\nSincerely,\n\n%s", this._from, this._text, this._to);
	    }

	    public static void main(String[] args) 
	    {
	        P8_9 letter = new P8_9("John", "Mary");
	        letter.addLine("I am sorry we must part.");
	        letter.addLine("I wish you all the best.");
	        System.out.println(letter.getText());	
	    }
}
