grammar Day4;

options {
	language = Java;
}

@header {
import com.adventofcode.soluce.day4.ASD;
}

scratchcards returns [ASD.Scratchcard out]
	@init {
	    ASD.Scratchcard scratchcard = null;
	}
  : (scratchcard[scratchcard] {
  	scratchcard = $scratchcard.out;
	})+ {
		$out = scratchcard;
	}
	;

scratchcard [ASD.Scratchcard previous] returns [ASD.Scratchcard out]
	: (CARD cardNumber=INT COLON num=numbers PIPE winNum=numbers) {
		$out = new ASD.Scratchcard(previous, Integer.parseInt($cardNumber.text), $num.out, $winNum.out);
	}
	;

numbers returns [List<Integer> out]
	@init {
	    List<Integer> numbers = new ArrayList<Integer>();
	}
	: (number=INT {
		numbers.add(Integer.parseInt($number.text));
	})+ {
		$out = numbers;
	}
	;

INT
   // integer part forbis leading 0s (e.g. `01`)
   : '0' | [1-9][0-9]*
   ;

COLON : ':';
CARD : 'Card';
PIPE : '|';

WS
   : [ \t\n\r] + -> skip
   ;