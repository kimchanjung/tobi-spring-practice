package spring.practice.kotlin.designPattern.commandPattern

/**
 * Created by kimchanjung on 2020-05-11 4:08 오후
 * [Command Pattern]
 * https://gmlwjd9405.github.io/2018/07/07/command-pattern.html
 * 커맨드 패턴은 일련의 요청 명령을 캡슐화 하여 client에 제공하는 패턴이다.
 * 요청 명령은 수행로직이나 필요한 정보가 종류에 따라 다양 할 수 있는 일련의 로직을
 * 실행()이라는 메소드로 캡슐화하여 client에게 간단하게 제공하는 패턴이다
 * 이로써 클라이언트와 작업을 수행하는 객체 사이의 의존성을 제거하고
 * 클라이언트는 복잡한 수행방법을 알 필요 없다.
 *
 * 장점
 *  - 기존 Code를 수정하지 않고, 새 명령을 쉽게 추가할 수 있다
 *  - 명령의 호출자와 수신자의 의존성을 제거한다.
 * 단점
 *  - 명령에 대한 클래스가 늘어난다.
 *
 */


interface DeliveryCommand {
    fun execute(): String
}

class MotorCycle {
    fun start() = "오토바이출발"
}

class Bike {
    fun pedaling() = "자전거출발"
}

class MotorCycleCommand(private var motorCycle: MotorCycle) : DeliveryCommand {
    override fun execute() = motorCycle.start()
}

class BikeCommand(private var bike: Bike) : DeliveryCommand {
    override fun execute() = bike.pedaling()
}


class Rider(private var deliveryCommand: DeliveryCommand) {
    fun changeDeliveryCommand(deliveryCommand: DeliveryCommand): Rider {
        this.deliveryCommand = deliveryCommand
        return this
    }

    fun delivery() = deliveryCommand.execute()
}