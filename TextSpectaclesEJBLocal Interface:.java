 package ac.za.tut.textspectaclessb.lb;

import ac.za.tut.exception.EmptyValueException;
import ac.za.tut.exception.MessageContainsDigitsException;
import java.util.Map;
import javax.ejb.Local;

 
@Local
public interface TextSpectaclesEJBLocal {

    Map<String,Integer> frequencyWordsOccurrence(String message)throws EmptyValueException,
                                                           MessageContainsDigitsException ;
    
    
    
}
