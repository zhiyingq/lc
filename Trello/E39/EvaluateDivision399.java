import java.util.Map;
import java.util.HashMap;
class EvaluateDivision399 {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    	Map<String, String> roots = new HashMap<>();
    	Map<String, double[]> lengthsize = new HashMap<>();
    	int count = 0; // to count the values 
    	for (String[] equation : equations) {
    		// whether contains or not
    		for (int i = 0; i <= 1; i++) {
    			// If no data, "a", "a";  "a", {1,1} first: value, second:size
    			if (roots.get(equation[i]) == null) {  
    				roots.put(equation[i], equation[i]); 
    				lengthsize.put(equation[i], new double[]{1.0, 1.0});
    			}
    		}

    		// get the small and large string
    		String large = equation[0];
    		String small = equation[1];
    		double co = values[count];
    		if (lengthsize.get(equation[0])[1] < lengthsize.get(equation[1])[1]) {
    			large = equation[1]; small = equation[0];
    			co = 1 / values[count];
    		}		
    		// put small to large and update the value
    		updateRootAndLength(roots, lengthsize, small, large, co);
    		count++;
    	}

    	double[] answer = new double[queries.length];
    	count = 0;
    	for (String[] query : queries) {
    		boolean notExist = false;
    		for (int i = 0; i <= 1; i++) {
    			if (roots.get(query[i]) == null) {
    				notExist = true;
    			}
    		}

    		if (!notExist) {
    			String numerator = query[0];
    			String denominator = query[1];
    			double dnumerator = 1.0;
    			double ddenominator = 1.0;
    			while (roots.get(numerator) != numerator) {
    				dnumerator *= lengthsize.get(numerator)[0];
    				numerator = roots.get(numerator);
    			}
    			while (roots.get(denominator) != denominator) {
    				ddenominator *= lengthsize.get(denominator)[0];
    				denominator = roots.get(denominator);
    			}
    			if (dnumerator == denominator) { answer[count] = ddenominator / dnumerator; }
    			else { answer[count] = -1; }
    		}
    		else {
    			answer[count] = -1;
    		}
    		count++;
    	}

    	return answer;
    }

    private void updateRootAndLength(Map<String, String> roots, 
    	Map<String, double[]> lengthsize, String small, String large, double e) {
    	double dsmall = 1.0; String smallroot = small;
    	double dlarge = 1.0; String largeroot = large;
    	while (roots.get(smallroot) != smallroot) {
    		dsmall *= lengthsize.get(smallroot)[0];
    		smallroot = roots.get(smallroot);
    	} 
    	while (roots.get(largeroot) != largeroot) {
    		dlarge *= lengthsize.get(largeroot)[0];
    		largeroot = roots.get(largeroot);
    	} 
    	roots.put(smallroot, largeroot);
    	double length = e * dlarge / dsmall;
    	double size = lengthsize.get(smallroot)[1] + lengthsize.get(largeroot)[1];
    	lengthsize.get(largeroot)[1] = size;
    	lengthsize.get(smallroot)[0] = length;
    }

    public static void main(String[] args) {

    }
}