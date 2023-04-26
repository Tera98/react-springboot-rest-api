# [프로젝트] Spring Boot 상품 관리, 주문관리 API 구현

### 1. 기획
- 상품 관리, 주문 관리 API 구현

### 2. 설계
- Product, Order, Customer Domain으로  나누어 설계

### 3. 구현
- 대략적인 코드 예시
- Update 구현 할 때 사용되는 Method

    public OrderDto updateOrder(Order order) {
    
        OrderDto oldData = order.toDto();
        BeanUtils.copyProperties(this, oldData, getNullPropertyNames(this));
        return oldData;
    }
- OrderStatus 변경할 때 사용되는 Method

    public void modifyStatus(String status) {
    
        if (!orderStatus.canModifyStatus(status)) throw new OrderException(OrderExceptionType.INVALID_STATUS);
        orderStatus = orderStatus.modifyStatus(status);
    }

### 4. 테스트
- Postman 이용 test

### 5.유지 보수
- Refactoring



