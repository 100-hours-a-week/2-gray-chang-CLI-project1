package calculatorService;

import calculatorEnum.MethodName;

import java.util.HashMap;
import java.util.Map;

public class MethodNameMapper {
    private Map<String, MethodName> methodNameMap = new HashMap<>();

    public MethodNameMapper() {
        this.methodNameMap.put("더하기", MethodName.plus);
        this.methodNameMap.put("빼기", MethodName.minus);
        this.methodNameMap.put("곱하기", MethodName.multiple);
        this.methodNameMap.put("나누기", MethodName.divide);
        this.methodNameMap.put("사인", MethodName.sin);
        this.methodNameMap.put("코사인", MethodName.cos);
        this.methodNameMap.put("탄젠트", MethodName.tan);
    }

    public MethodName getMethodName(String methodName) {
        return this.methodNameMap.getOrDefault(methodName, null);
    }

}

