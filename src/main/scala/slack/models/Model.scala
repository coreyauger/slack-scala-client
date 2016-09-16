package slack.models

trait Chat{
  def id: String
  def created: Long
}

case class ChatValue (
  value: String,
  creator: String,
  last_set: Long
)