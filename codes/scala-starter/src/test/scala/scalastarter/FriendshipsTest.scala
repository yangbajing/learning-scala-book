package scalastarter

import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpec}

class FriendshipsTest extends WordSpec with BeforeAndAfterAll with MustMatchers {

  private var friendships: Friendships = _

  "FriendshipsTest" should {

    "getFriendList" in {
      friendships.getFriendList("羊八井") must not be empty
    }

    "isFriends" in {
      friendships.isFriends("羊八井", "老猪") mustBe true
    }

  }

  // 这个方法在初始化阶段执行一次
  override protected def beforeAll(): Unit = {
    friendships = new Friendships()
    friendships.makeFriends("羊八井", "大魔头")
    friendships.makeFriends("羊八井", "老猪")
    friendships.makeFriends("羊八井", "老高")
  }

}
