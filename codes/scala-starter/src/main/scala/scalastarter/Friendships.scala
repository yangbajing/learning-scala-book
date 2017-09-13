package scalastarter

class Friendships {

  private var friendships = Map.empty[String, List[String]]

  def makeFriends(person1: String, person2: String): Unit = {
    addFriend(person1, person2)
  }

  def getFriendList(person: String): List[String] =
    friendships.getOrElse(person, Nil)

  def isFriends(person: String, friend: String): Boolean =
    friendships.get(person).exists(friends => friends.contains(friend))

  private def addFriend(person: String, friend: String): Unit = {
    if (!friendships.contains(person)) {
      friendships = friendships.updated(person, List(friend))
    }
    val friends = friendships(person)
    if (!friends.contains(friend)) {
      friendships = friendships.updated(person, friend :: friends)
    }
  }

}
