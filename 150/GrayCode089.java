class GrayCode089 {
	/*
	我们知道，假设n=3,那么当n=2的时候有：
	(00, 01, 11, 10)
	所以其实我们把第一位看作0，那么后面只需要对称地把1加上去就可以了：
	(000, 001, 011, 010) + (110, 111, 101, 100)

	当n=0时，起始值为[0]
	那么要到n的话我们一共要进行n次循环
	每次循环都是取上次的结果+ 1 << (n-1)
	*/
	public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        // 共需操作n次
        for (int i = 1; i <= n; i++) {
        	// 上一层有1 << (i - 1)个数，逐个从后往前取出
        	for (int j = (1 << (i - 1)) - 1; j >= 0; j--) {
                // 加上恒定值 1 << (i - 1)
        		list.add((1 << (i - 1)) + list.get(j));
        	}
        }
        return list;
    }
}