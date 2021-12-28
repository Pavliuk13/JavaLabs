/*Сформировать массив b  из исходного одномерного массива  a следующим образом: если amin < bi < amax,
то bi = ai; если bi ≤ amin, то bi=amin; если bi ≥ amax, то bi=amax (amax и amin  - заданные значения).
 */


public class Fifth {
    public int[] createArray(int amax, int amin, int[] a){
        if(a.length == 0)
            return null;
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++)
            if(a[i] < amax && a[i] > amin)
                b[i] = a[i];
            else if(a[i] >= amax)
                b[i] = amax;
            else if(a[i] <= amin)
                b[i] = amin;
        return b;
    }
}
