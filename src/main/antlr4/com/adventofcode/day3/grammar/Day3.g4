grammar Day3;

options {
	language = Java;
}

@header {
import com.adventofcode.soluce.day3.ASD;
}

engine returns [ASD.Engine out]
	 @init {
	 		List<ASD.Part> parts = new ArrayList<>();
	 }
	 : (part {
	 		parts.add($part.out);
	 })* EOF {
	 		$out = new ASD.Engine(parts);
	 }
	 ;

part returns [ASD.Part out]
	: value=INT {
		$out = new ASD.Number($value.getCharPositionInLine(), $value.getLine(), $value.getText().length(), 1, $value.text);
	}
	| value=DOT {
    $out = new ASD.Empty($value.getCharPositionInLine(), $value.getLine(), $value.getText().length(), 1, $value.text);
  }
  | value=GEAR {
		$out = new ASD.Gear($value.getCharPositionInLine(), $value.getLine(), $value.getText().length(), 1, $value.text);
	}
	| value=SYMBOL {
    $out = new ASD.Symbol($value.getCharPositionInLine(), $value.getLine(), $value.getText().length(), 1, $value.text);
  }
	;

DOT : '.';

GEAR
	: '*'
	;

INT
   // integer part forbis leading 0s (e.g. `01`)
   : '0' | [1-9][0-9]*
   ;

SYMBOL
  : .
  ;





WS
   : [ \t\n\r] + -> skip
   ;