package logo;

public class LogoNakedBank {
	
	
	
	public void mostrarLogo(){
		
		String[] bank = {
				
				"========================================================",
                "-                                                      -",
                "-    ******          *         *      *    *     *     -",
                "-    *     *        * *        **     *    *    *      -",
                "-    *     *       *   *       * *    *    *   *       -",
                "-    ******        *****       *  *   *    ****        -",
                "-    *     *      *     *      *   *  *    *   *       -",
                "-    *     *     *       *     *    * *    *    *      -",
                "-    ******     *         *    *     **    *     *     -",
                "-                                                      -",
                "========================================================"	
                
		};

        for (String line : bank) {
            System.out.println(line);

    }
		
	}

}
