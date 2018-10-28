package com.techmonad.mongo


import com.techmonad.mongo.BSONDocumentConverter._
import reactivemongo.api.commands.{UpdateWriteResult, WriteResult}
import reactivemongo.bson.{BSONDocument, BSONObjectID}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait QueryDetailCollection {
  self: ConnectionProvider =>


  def create(queryDetail: QueryDetail): Future[WriteResult] =
    collection.insert(queryDetail)


  def update(queryDetail: QueryDetail): Future[UpdateWriteResult] =
    collection.update(ordered = false)
      .one(
        q = BSONDocument("_id" -> queryDetail.id),
        u = queryDetail,
        upsert = true,
        multi = false
      )


  def delete(id: BSONObjectID): Future[WriteResult] =
    collection.delete(ordered = false)
      .one(
        q = BSONDocument("_id" -> id)
      )


  def findById(id: BSONObjectID): Future[QueryDetail] =
    collection.find(BSONDocument("_id" -> id)).requireOne

}


object QueryDetailCollection extends ConnectionProvider {
  override protected val collectionName: String = "query-detail"
}


