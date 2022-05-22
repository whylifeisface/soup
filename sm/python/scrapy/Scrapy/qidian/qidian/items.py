# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy
from scrapy import Field
from itemloaders.processors import SelectJmes, Compose, MapCompose




class QidianItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    # pass
    book_name = Field()
    photo_url = Field()
    author = Field()
    Classification = Field()
    Classification_detail = Field()
    book_status = Field()
    book_size = Field()
