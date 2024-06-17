package com.example.ToolManagment.api.tool;

import com.example.ToolManagment.api.tool.dto.ToolDtoAdd;
import com.example.ToolManagment.api.tool.dto.ToolDtoUpdate;
import com.example.ToolManagment.domain.tool.Tool;
import com.example.ToolManagment.domain.tool.ToolRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tool")
public class ToolController {
    final ToolRepository toolRepository;

    public ToolController(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @GetMapping("/all")
    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    @GetMapping("/{id}")
    Tool getById(@PathVariable Integer id) {
        return toolRepository.findById(id).get();
    }

    @PostMapping("/add")
    Tool add(@RequestBody ToolDtoAdd addDto) {
        Tool toolToBeSaved = new Tool();
        toolToBeSaved.setManufacturer(addDto.getManufacturer());
        toolToBeSaved.setType(addDto.getType());
        toolToBeSaved.setPrice(addDto.getPrice());
        toolToBeSaved.setStatus(addDto.getStatus());
        toolToBeSaved.setQrCode(addDto.getQrCode());
        return toolRepository.save(toolToBeSaved);

    }

    @PostMapping("/update/{id}")
    Tool update(@PathVariable Integer id,
                @RequestBody ToolDtoUpdate updateDto) {
        Tool toolToUpdate = toolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool with ID: " + id + " does not exist!"));

        toolToUpdate.setStatus(updateDto.getStatus());

        return toolRepository.save(toolToUpdate);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id) {
        Tool toolToDelete = toolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool with ID: " + id + " does not exist!"));
        toolRepository.delete(toolToDelete);
        return ResponseEntity.ok("Tool has been deleted");
    }

}
