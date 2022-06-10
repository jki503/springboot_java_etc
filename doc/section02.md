---
Title: 02. Java Version 대체 그게 뭔데..]
Category: Java, 버전
Author: Jung
---

</br>

## Table of Contents

- [Table of Contents](#table-of-contents)
  - [명색의 자바 개발잔데 자바 버전을 너무 모르는 거 아닌가..](#명색의-자바-개발잔데-자바-버전을-너무-모르는-거-아닌가)
  - [문제점](#문제점)
  - [Optional](#optional)

</br>

### 명색의 자바 개발잔데 자바 버전을 너무 모르는 거 아닌가..

- Java 8
  - 람다 표현식 : 함수형 프로그래밍
  - 스트림 API : 데이터 추상화
  - Optional
  - default method
- Java 10
  - var 키워드
- Java 11
  - 뭔지 모름..
  - 사실 뭐 실무에서 가장 많이 쓰고 있다고 하니깐.
  - `사실 더 웃긴게 대부분 스프링 개발자들 김영한님 강의 때매 11로 시작하지 않았을까.`
- Java 14
  - record

</br>

> 대충 아는 것이 이게 다다..
> 사실 내가 개인적으로 메인으로 사용하는 것은 11이고  
> 현재 데브코스 공부를 하면서 학습의 이유로 높여서 17을 사용하고 있다.

### 문제점

</br>

> 내가 쓰고 있는 메인 기능들이 무슨 버전인지 모른다.  
> 사실 큰 문제라고 생각하지도 않았고,  
> 자바 높은 버전을 사용한다고 해서, 모든 기능을 사용하는 것도 아니고,  
> 내가 11로 썼던 기능들이 문제 없이 상위버전에선 돌아가니까 인지하지 못했다.

</br>

> 프로젝트 얘기도중 Optional에서 자주 쓰이는 메서드들이  
> 9, 10, 11에서 추가된 것을 알 수 있었고,  
> 8로 내려서 프로젝트를 했더라면,  
> 뭐 어차저차 개발은 했겠지만, 상당히 불편했을 것같다...

</br>

### Optional

- isEmpty(11이후부터)

```java
    /**
     * If a value is  not present, returns {@code true}, otherwise
     * {@code false}.
     *
     * @return  {@code true} if a value is not present, otherwise {@code false}
     * @since   11
     */
    public boolean isEmpty() {
        return value == null;
    }

```

</br>

- ifPresentOrElse(10 이후부터)

```java
    /**
     * If a value is present, performs the given action with the value,
     * otherwise performs the given empty-based action.
     *
     * @param action the action to be performed, if a value is present
     * @param emptyAction the empty-based action to be performed, if no value is
     *        present
     * @throws NullPointerException if a value is present and the given action
     *         is {@code null}, or no value is present and the given empty-based
     *         action is {@code null}.
     * @since 9
     */
    public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
        if (value != null) {
            action.accept(value);
        } else {
            emptyAction.run();
        }
    }
```

</br>

- orElseThrow(10 이후부터)

```java
    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @return the non-{@code null} value described by this {@code Optional}
     * @throws NoSuchElementException if no value is present
     * @since 10
     */
    public T orElseThrow() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

```

</br>

> 내가 제일 즐겨 쓰는 것은 map()과 OrElseThrow()  
> service layer에서 값을 가져와서 response로 변환하고  
> 없으면 예외처리해줘서 굉장히 편하다.  
> 틈틈히 기회가 된다면 내가 쓰는 기능들이 버전이 어떻게 되는지 확인 해보기.

</br>
