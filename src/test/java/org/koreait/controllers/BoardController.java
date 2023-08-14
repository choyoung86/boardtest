package org.koreait.controllers;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.koreait.models.board.BoardData;
import org.koreait.models.board.BoardSaveService;
import org.koreait.models.board.DeleteService;
import org.koreait.models.board.InfoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Component
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardSaveService boardSaveService;
    private final InfoService infoService;
    private final DeleteService deleteService;
    private BoardForm boardForm;

    @GetMapping("/write")
    public String write(Model model) {
        boardForm = new BoardForm();
        model.addAttribute("boardForm", boardForm);
        return "board/write";
    }

    @PostMapping("/write")
    public String writePs(@Valid BoardForm boardForm, Errors errors) {
        boardSaveService.save(boardForm);

        if (errors.hasErrors()) {
            return "board/write";
        }
        return "redirect:/board/list";

    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable long id, Model model){
        BoardData data=infoService.get(id);
        model.addAttribute("data", data);
        return "board/view";
    }
    @GetMapping("/list")
    public String list(Model model){
        List<BoardData> items=infoService.gets();
        model.addAttribute("items", items);

        return "board/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Long id, Model model) {
        deleteService.deleteBoard(id);

        return "redirect:/board/list";
    }
}