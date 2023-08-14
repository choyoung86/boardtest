package org.koreait.controllers;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.koreait.models.board.BoardSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardSaveService boardSaveService;
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

}