/**
 * Provides a simple word object that stores a word together with its letters
 * sorted.
 *
 * @author T.Sergeant
 * @version for Program Design 2
 *
 *
 */
import java.util.Arrays;

public class Word implements Comparable<Word>
{
	private String word;    // the word
	private String sorted;  // the word re-arranged so that its letters are sorted

	/**
	 * Store the word and create a sorted version of the word.
	 *
	 * @param word the word to be stored
	 */
	public Word(String word)
	{
		char [] letters= word.toCharArray();
		Arrays.sort(letters);
		this.word= word;
		this.sorted= new String(letters);
	}

	/**
	 * Just show the regular word when object is printed.
	 *
	 * @return the regular word
	 */
	public String toString()
	{
		return this.word + "(" + sorted + ")";
	}
   
   /**
    * Override equals
    */
   @Override
   public boolean equals(Object obj)
   {
      if(obj == null || obj.getClass() != this.getClass())
      {
         return false;
      }
      
      final Word w = (Word) obj;
      return this.word.equals(w.word);
   }  
   
   /**
    *  Override the hashcode
    */
   @Override
   public int hashCode()
   {
      return this.word.hashCode();
   }
   
   /**
    *  Checks to see if two words are anagrams
    *
    *  @param w Word object to compare to
    */
   public boolean anagramCheck(Word w)
   {
      if(this.sorted.equals(w.sorted))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
    *  Compares this Word to another Word
    *
    *  @param w Word to compare to
    *  @return a negative if w is greater, a zero if equal, and positive if w is less
    */
   public int compareTo(Word w)
   {
      return this.sorted.compareTo(w.sorted);
   }
}
