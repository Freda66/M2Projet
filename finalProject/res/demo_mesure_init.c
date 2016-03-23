#include <stdio.h>
#include <stdlib.h>

float main(int argc, char ** argv) {
	float y;
	y = 2.0;
	printf("BDDVariable:y;%.19f\n",(y+atof(argv[1])));

	printf("BDDResult:y;%.19f\n",y);
	return y;
}