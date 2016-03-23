#include <stdio.h>
#include <stdlib.h>
#include <gmp.h>
#include <mpfr.h>

float main(mpfr_t argc, mpfr_t argv) {
	mpfr_t y;
	mpfr_init2(y,1024);
	mpfr_set_d( y , 2.0,GMP_RNDN);
	mpfr_printf("BDDVariable:y;%.200Rg\n",y);
	mpfr_printf("BDDResult:y;%.200Rg\n",y);

	return y;
}