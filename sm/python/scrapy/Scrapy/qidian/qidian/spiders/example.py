import scrapy
from scrapy import Selector
from scrapy.spiders import Rule, CrawlSpider
from scrapy.linkextractors import LinkExtractor

from ..items import QidianItem


class ExampleSpider(CrawlSpider):
    name = 'example'
    # allowed_domains = ['example.com4']
    start_urls = ['https://www.qidian.com/all/page2/']
    # rules 在这个爬虫中才有用CrawlSpider
    rules = (
        Rule(LinkExtractor(restrict_css=('.lbf-pagination-item a')), callback='parse'),
    )

    def parse(self, response, *args):
        item = QidianItem()
        selector = Selector(text=response.text)
        books = selector.css('#book-img-text ul li')
        print(len(books))
        for book in books:
            # print(book)
            status = book.css('.book-mid-info .author span::text').get()
            if(status=='连载'):status = 0
            else:status=1
            item['book_name'] = book.css('.book-mid-info h2 a::text').get()
            item['photo_url'] = book.css('.book-img-box a img::attr(src)').get()
            item['author'] = book.css('.book-mid-info .author .name::text').get()
            item['Classification'] = book.xpath('./div[@class="book-mid-info"]/p/a[2]/text()').get()
            item['Classification_detail'] = book.css('.book-mid-info .author .go-sub-type::text').get()
            item['book_status'] = status
            item['book_size'] = book.css('.update span span::text').get()
            yield item