#include <gmp.h>
#include <mpfr.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
	mpfr_t y;
	mpfr_init2 (y,1024);
	mpfr_set_d( y , 2.0001,GMP_RNDN);
	mpfr_printf("BDDMeasurement:y;%.200Rg\n",y);

	return 0;
}