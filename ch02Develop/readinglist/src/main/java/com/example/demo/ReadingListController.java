package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller // 组件扫描会自动将其注册为Spring应用程序上下文里的一个Bean
@RequestMapping("/")    // 将其中所有的处理器方法都映射到了“/”这个URL路径上。
public class ReadingListController {
    

    
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    // 处理/{reader}上的HTTP GET 请求，根据路径里指定的读者
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList"; // 视图文件名
    }

    // 处理/{reader}上的HTTP POST 请求，将请求正文里的数据绑定到一个 Book 对象上。
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
