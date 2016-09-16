package slack.models

import play.api.libs.json._

case class Channel (
  id: String,
  name: String,
  created: Long,
  creator: String,
  is_archived: Option[Boolean],
  is_member: Option[Boolean],
  is_general: Option[Boolean],
  is_channel: Option[Boolean],
  is_group: Option[Boolean],
  is_mpim: Option[Boolean],
  num_members: Option[Int],
  members: Option[Seq[String]],
  topic: Option[ChatValue],
  purpose: Option[ChatValue],
  last_read: Option[String],
  latest: Option[JsValue],
  unread_count: Option[Int],
  unread_count_display: Option[Int]
) extends Chat
