package org.koreait.controllers;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.koreait.models.board.BoardData;
import org.koreait.models.board.BoardSaveService;
import org.koreait.models.board.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardSaveService boardSaveService;
    private final InfoService infoService;
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


}