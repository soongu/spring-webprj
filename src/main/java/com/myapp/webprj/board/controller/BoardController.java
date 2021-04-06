package com.myapp.webprj.board.controller;

import com.myapp.webprj.board.domain.Board;
import com.myapp.webprj.board.service.BoardService;
import com.myapp.webprj.paging.Criteria;
import com.myapp.webprj.paging.PageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Criteria cri, Model model) {
        log.info("/board/list" + cri);
        model.addAttribute("list", boardService.getList(cri));
        model.addAttribute("pageMaker", new PageDTO(cri, boardService.getTotal(cri)));
        return "board/list";
    }

    @GetMapping("/register")
    public String register() {
        return "board/register";
    }

    @PostMapping("/register")
    public String register(Board board, RedirectAttributes rttr) {
        log.info("/board/register: " + board);
        boardService.register(board);
        rttr.addFlashAttribute("result", "regSuccess");

        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public String get(Long bno, Model model) {
        log.info("/board/get: " + bno);
        model.addAttribute("board", boardService.get(bno));

        return "board/get";
    }

    @GetMapping("/modify")
    public String modify(Long bno, Model model) {
        log.info("/board/modify: " + bno);
        model.addAttribute("board", boardService.get(bno));

        return "board/modify";
    }

    @PostMapping("/modify")
    public String modify(Board board, RedirectAttributes rttr) {
        log.info("/board/modify: " + board);

        if (boardService.modify(board)) {
            rttr.addFlashAttribute("result", "modSuccess");
        }
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes rttr) {
        log.info("/board/remove: " + bno);
        if (boardService.remove(bno)) {
            rttr.addFlashAttribute("result", "delSuccess");
        }
        return "redirect:/board/list";
    }
}
