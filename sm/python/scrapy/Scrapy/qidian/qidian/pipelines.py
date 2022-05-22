# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
import pymysql
from itemadapter import ItemAdapter


class BizhiPipeline_MySQL(object):
    def open_spider(self, spider):
        # 创建数据库连接
        self.conn = pymysql.connect(host='localhost', user='root', password='root', database='one')
        # 创建游标对象
        self.cursor = self.conn.cursor()
    def process_item(self,item,response):
        global a
        # sql语句
        insert_sql = """
                insert into book_Classification(book_name,photo,author,Classification,book_status) VALUES (%s,%s,%s,%s,%s)
                """
        # 插入到数据库
        self.cursor.execute(insert_sql, (item['book_name'], item['photo_url'], item['author'], item['Classification'], item['book_status']))
        # 提交数据
        self.conn.commit()

    def close_spider(self, spider):
        # 关闭游标和连接
        self.cursor.close()
        self.conn.close()
class Pipeline_MySQL(object):
    def open_spider(self,spider):
        # 创建数据库连接
        self.conn = pymysql.connect(host='localhost', user='root', password='root', database='one')
        # 创建游标对象
        self.cursor = self.conn.cursor()
    def process_item(self,item,response):
        global a
        # sql语句
        insert_sql = """
                insert into (book_name,photo_url,Classification,Classification_detail,book_status,book_size,author) VALUES (%s,%s,%s,%s,%s,%s,%s)
                """
        # 插入到数据库
        self.cursor.execute(insert_sql, (item['book_name'], item['photo_url'], item['Classification'], item['Classification_detail'], item['book_status'], item['book_size'], item['author']))
        # 提交数据
        self.conn.commit()

    def close_spider(self, spider):
        # 关闭游标和连接
        self.cursor.close()
        self.conn.close()