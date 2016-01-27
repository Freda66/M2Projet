#include <gmp.h>
#include <mpfr.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
	mpfr_t y;
	mpfr_init2 (y,256);
	mpfr_set_d( y , 2.0,GMP_RNDN);

	return 0;
}