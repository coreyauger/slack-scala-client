package slack.models

import play.api.libs.json._

case class Group (
  id: String,
  name: String,
  is_group: Boolean,
  created: Long,
  creator: String,
  is_archived: Boolean,
  members: Seq[String],
  topic: ChatValue,
  purpose: ChatValue,
  last_read: Option[String],
  latest: Option[JsValue],
  unread_count: Option[Int],
  unread_count_display: Option[Int]
) extends Chat