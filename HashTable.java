/*
 * HashTable.java
 *
 * Created on November 9, 2005, 7:10 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package hash;

public class HashTable {
    
    int size;			//ESTA SERA EL TAMANIO DE LA TABLA 
    int[] table;		//ESTA SERA LA TABLA HASH, UN ARRAY, EL VALOR SE DEFINE LUEGO 

    int numItems = 0;	// ESTE SERA EL INDICE, EL NUMERO EN DONDE SE ALMACENARA DENTRO DE LA TABLA
    

    //***********************************AQUI SE CREA LA TABLA *******************************************
    public HashTable(int size) {
        this.size = size;			//AQUI DECIMOS QUE EL VALOR DE SIZE SERA EL QUE SE INGRESE EN LA APP
        table = new int[size];		//CREAMOS LA TABLA CON EL VALOR INGRESADO POR EL USUARIO EN LA APP
        for (int i=0; i < table.length ; i++)	//RECORREO UNO POR POR UNO CADA ESPACIO DE LA TABLA
        	table[i]=-1;						//LE AGREGA UN VALOR DE -1 A CADA ESPACIO DE LA TABLA 
        

    }
    
//*****************AQUI SE INSERTAN LOS VALORES*************************************************************
//		NOTA EL VALOR Q RETORNA ES EL NUMERO DE COLISIONES, HUBIESE SIDO BUENO SABERLO DESDE EL INCICIO

    public int insert(int n) {
        
    	numItems = n%size ;			//INDICAMOS QUE EL ESPACIO DE TABLA SERA EL NUMERO INGRESADO MOD EL TAMANIO DE LA TABLA
    	int colisiones =0;
    	
    	if (table[numItems] != -1) 	//SI EL VALOR DE LA TABLA ES -1 EXISTE YA UN VALOR EN ESE ESACIO
    	{
    		
    		boolean full = true;		//ESTA VARIABLE LA USAMOS PARA COMPROBAR SI LA TABLA ESTA LLENA
    		
    	       for (int i=numItems; i < table.length ; i++)	//RECORREO UNO POR POR UNO CADA ESPACIO DE LA TABLA
    	        	{if (table[i]==-1)			//PREGUNTAMOS SI EL SIGUIENTE VALOR ESTA VACIO   -1 = VACIO
    	        		{table[i] = n;			// SI ESTA VACIO LE AGREGAMOS EL VALOR A INSERTAR 
    	        		full = false;			//LUEGO DE AGREGAR EL VALOR INDICAMOS QUE NO ESTA VACIO LA TABLA
    	        		break;}					//CERRAMOS EL FOR, YA OBTUVIMOS LO QUE BUSCABAMOS
    	        	colisiones+=1;
    	        	}
    	 
    	       if (full == true )				//SI EL CONTEO HACIA EL ULTIMO NO FUE EXITOSO BUSCAMOS DESDE 0
    	       {
    	    	   for (int i=0; i < numItems; i++)
    	    	   {if (table[i]==-1)			//PREGUNTAMOS SI EL SIGUIENTE VALOR ESTA VACIO   -1 = VACIO
	        		{table[i] = n;			// SI ESTA VACIO LE AGREGAMOS EL VALOR A INSERTAR 
	        		full = false;
	        		break;}
    	    		 colisiones+=1;  
    	    	   }
    	       }
    	       
    	       if (full == true)			//SI NO ENCONTRAMOS NINGUN ESPACIO VACIO DEVOLVEMOS -1 = TABLA LLENA
    	       {
    	    	   return -1;
    	       }
    	return colisiones;				//RETORNAMOS LA CANTDAD DE COLLISONES QUE BUERON, 
    	}
    	
    	else 
    	table[numItems]=n;		// EN EL MEJOR DE LOS CASOS EL ESAPCIO ESTA VACIO Y AGREGAMOS DE UNA EL VALOR 
        
    	
        return 0;
    }

    //*********RETORNAMOS UN VALOR CUALQUIERA Y NO PASA NADA, LAS COLISIONES LAS TOMA DEL INSETAR 0.O
    public int contains(int n){

        for (int i=0; i < table.length ; i++)		//BUSCAMOS UNO POR UNO EN CADA ESPACIO
        {
        	if ( n == table[i])					//SI ENCONTRAMOS EL VALOR LO QUITAMOS Y RETORNAMOS 0
        	{	
        	return 0;
        	}
        }
        return -1;
    }

     
    public int remove(int n) {
    

        for (int i=0; i < table.length ; i++)		//BUSCAMOS UNO POR UNO EN CADA ESPACIO
        {
        	if ( n == table[i])					//SI ENCONTRAMOS EL VALOR LO QUITAMOS Y RETORNAMOS 0
        	{	
        		table[i]= -1;
        	return 0;
        	}
        }
        return -1;							// SI NO SE ENCUENTRA EL VALOR RETORNA -1 = NO SE ENCONTRO EL VALOR 
    }
    

    public String toString() {
        String s = "(";
        
        for (int i=0; i < table.length ; i++)	//CONSULTAMOS UNO A UNO LOS ESPACIOS DE LA TABLA
        	if (table[i]  ==-1)					// SI LA TABLA VALE -1 = VACIO AGREGAMOS EL CARACTER *
        	{
        	s+= "* ,";	
        	}
        	else								//SI LA TABLA NO ESTA VACIA AGREGAMOS EL VALOR QUE TIENE
        	{
        		s+= table[i] + " ,";		
        	}
        
        s += ")";
        return s;
    }
}

