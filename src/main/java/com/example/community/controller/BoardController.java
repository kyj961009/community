package com.example.community.controller;


import com.example.community.domain.BoardVO;
import com.example.community.domain.Criteria;
import com.example.community.domain.PageMaker;
import com.example.community.domain.ResultDTO;
import com.example.community.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/community/")
@AllArgsConstructor
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping({"","/list"})
    public String list(Criteria criteria, Model model) {
        log.info("list = {}", criteria);

        long total = boardService.getTotal(criteria);

        log.info("total = {}", total);

        model.addAttribute("list", boardService.getList(criteria));

        model.addAttribute("pageMaker", new PageMaker(criteria, total));

        return "/community/list";
    }

    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String write(BoardVO boardVO, RedirectAttributes redirectAttributes) {
        log.info("write = {}", boardVO);

        boardService.register(boardVO);

        redirectAttributes.addAttribute("id", boardVO.getId());
        redirectAttributes.addFlashAttribute("result", new ResultDTO(true, "write"));

        return "redirect:/community/read";
    }

    @GetMapping("/update")
    public String update(@RequestParam Long id, Criteria criteria, Model model) {
        log.info("update = {}", id);

        model.addAttribute("board", boardService.get(id));

        return "/community/write";
    }

    @PostMapping("/update")
    public String update(BoardVO boardVO, Criteria criteria, RedirectAttributes redirectAttributes) {
        log.info("update = {]", boardVO);

        if (boardService.update(boardVO))
            redirectAttributes.addFlashAttribute("result", new ResultDTO(true,"update"));

        redirectAttributes.addAttribute("id",boardVO.getId());
        redirectAttributes.addAttribute("page",criteria.getPage());

        return "redirect:/community/read";
    }

    @GetMapping("/read")
    public BoardVO read(@RequestParam Long id, Criteria criteria) {
        log.info("read = {}", id);

        return boardService.get(id);
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id, Criteria criteria, RedirectAttributes redirectAttributes) {
        log.info("delete = {}", id);

        // BoardService 인터페이스의 delete 메서드로 게시물을 삭제
        if (boardService.delete(id))
            redirectAttributes.addFlashAttribute("result", new ResultDTO(true, "delete"));

        // URL 재지정할 때 전달할 요청 매개 변수를 설정
        redirectAttributes.addAttribute("page", criteria.getPage());

        // "/board/list"로 재지정
        return "redirect:/board/list";
    }


}
