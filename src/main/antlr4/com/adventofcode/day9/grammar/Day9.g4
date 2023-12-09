grammar Day9;

options {
	language = Java;
}

@header {
import com.adventofcode.soluce.day9.ASD;
}

report returns [ASD.Report out]
	@init {
		List<ASD.Suite> suites = new ArrayList<>();
	}
	: (suite NEWLINE? {
		suites.add($suite.out);
	})+ {
		$out = new ASD.Report(suites);
	}
	;

suite returns [ASD.Suite out]
	@init {
		List<Long> values = new ArrayList<>();
	}
	: (INT {
		values.add(Long.parseLong($INT.text));
	})+ {
		$out = new ASD.Suite(values);
	}
	;


INT: ('-'? DIGIT+);

DIGIT: [0-9];

NEWLINE : '\r'? '\n' ;

WS
	 : [ \t]+ -> skip
	 ;