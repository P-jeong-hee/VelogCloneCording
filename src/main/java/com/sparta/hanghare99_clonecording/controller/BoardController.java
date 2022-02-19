package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.BoardRegisterDto;
import com.sparta.hanghare99_clonecording.dto.BoardRegisterResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards/likes")
    public List<Board> getLikeBoards(){
        return boardService.getLikeBoards();
    }

    @PostMapping("/board/posting")
    public BoardRegisterResponseDto postingBoard(BoardRegisterDto requestDto){
        return boardService.postingBoard(requestDto);
    }

    @GetMapping("/board/detail/{postingId}")
    public Board readBoard(@PathVariable Long postingId) {
        return boardService.readBoard(postingId);
    }

    @PutMapping("/board/update/{postingId}")
    public Board updateBoard(@PathVariable Long postingId, @RequestBody  BoardRegisterDto boardRegisterDto) {
        return boardService.updateBoard(boardRegisterDto, postingId);
    }

    @Transactional
}