package com.techmonad.mongo

import com.techmonad.mongo.BSONDocumentConverter._
import reactivemongo.api.commands.{UpdateWriteResult, WriteResult}
import reactivemongo.bson.{BSONDocument, BSONObjectID}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


trait QueryStatusCollection {
  self: ConnectionProvider =>


  def create(queryStatus: QueryStatus): Future[WriteResult] =
    collection.insert(queryStatus)


  def update(queryStatus: QueryStatus): Future[UpdateWriteResult] =
    collection.update(ordered = false)
      .one(
        q = BSONDocument("queryId" -> queryStatus.queryId),
        u = queryStatus,
        upsert = true,
        multi = false
      )


  def delete(id: BSONObjectID): Future[WriteResult] =
    collection.delete(ordered = false)
      .one(
        q = BSONDocument("queryId" -> id)
      )


  def findById(id: BSONObjectID): Future[QueryStatus] =
    collection.find(BSONDocument("queryId" -> id)).requireOne

}



object QueryStatusCollection extends ConnectionProvider {

  override protected val collectionName: String = "query-status"

}


