1. result 값은?
```java
    public static int getResult(int x, int y){
        int sum = x + y;
        return sum;
    }
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        int result = getResult(a, b);
        System.out.println(result);
    }
```
답 : 300 

2. result 값은?
```java
    public static int getResult(int x, int y){
        int sum = x + y;
        if(sum == 300){
            return 0;
        }
        return sum;
    }
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        int result = getResult(a, b);
        System.out.println(result);
    }
```
답 : 0

3. result 값은?
```java
    public static int getResult(int x, int y){
        if(x == 100){
            ++x;
        }
        if(y == 200){
            ++x;
        }
        return x;
    }
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        int result = getResult(a, b);
        System.out.println(result);
    }
```

답 : 102

4. result 값은?
```java
    public static String getResult(String word){
        return word;
    }
    public static void main(String[] args) {
        String str = "apple";
        String result = getResult(str);
        System.out.println(result);
    }
```
답 : apple

=> 변수값은 중요하지 않고 데이터값이 뭔지가 중요함!
main에서 String값에 apple을 대입했기 때문에

5. result 값은?
```java
    public static String getResult(int x, int y){
        if(x == 100){
            return "토토로";
        }
        if(y == 200){
            return "토르";
        }
        return null;
    }
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        String result = getResult(a, b);
        System.out.println(result);
    }
```

답 : 토토로 