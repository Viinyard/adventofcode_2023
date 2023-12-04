grammar Day4;

options {
	language = Java;
}

@header {
import com.adventofcode.soluce.day4.ASD;
}

scratchcards returns [List<ASD.Scratchcard> out]
	@init {
	    List<ASD.Scratchcard> scratchcards = new ArrayList<ASD.Scratchcard>();
	}
  : (scratchcard {
  	scratchcards.add($scratchcard.out);
	})+ {
		$out = scratchcards;
	}
	;

scratchcard returns [ASD.Scratchcard out]
	: (CARD cardNumber=INT COLON num=numbers PIPE winNum=numbers) {
		$out = new ASD.Scratchcard(Integer.parseInt($cardNumber.text), $num.out, $winNum.out);
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