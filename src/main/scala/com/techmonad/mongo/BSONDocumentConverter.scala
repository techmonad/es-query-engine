package com.techmonad.mongo

import reactivemongo.bson.{BSONDocument, BSONDocumentReader, BSONDocumentWriter, BSONObjectID}

object BSONDocumentConverter {

  implicit object QueryDetailReader extends BSONDocumentReader[QueryDetail] {
    def read(doc: BSONDocument): QueryDetail = {
      val id = doc.getAs[BSONObjectID]("_id").get
      val json = doc.getAs[String]("json").get
      QueryDetail(id, json)
    }
  }


  implicit object QueryDetailWriter extends BSONDocumentWriter[QueryDetail] {
    def write(p: QueryDetail): BSONDocument =
      BSONDocument("json" -> p.json, "_id" -> p.id)
  }


  implicit object QueryStatusReader extends BSONDocumentReader[QueryStatus] {
    def read(doc: BSONDocument): QueryStatus = {
      val queryId = doc.getAs[BSONObjectID]("queryId").get
      val status = doc.getAs[String]("status").get
      val startAt = doc.getAs[Long]("startAt").get
      QueryStatus(queryId, status, startAt)
    }
  }


  implicit object QueryStatusWriter extends BSONDocumentWriter[QueryStatus] {
    def write(q: QueryStatus): BSONDocument =
      BSONDocument("queryId" -> q.queryId, "status" -> q.startAt, "startAt" -> q.startAt)
  }

}

case class QueryDetail(id: BSONObjectID, json: String)

case class QueryStatus(queryId: BSONObjectID, status: String, startAt: Long)