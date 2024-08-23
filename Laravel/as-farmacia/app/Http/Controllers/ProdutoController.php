<?php


namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\Models\Produto;


class ProdutoController extends Controller
{


    public function index()
    {
        $produtos = Produto::all();
        return view('produtos.index', compact('produtos'));
    }


    public function create()
    {
        return view('produtos.create');
    }


    public function store(Request $request)
    {
        $request->validate([
            'nome'=>'required|string|max:255',
            'descricao'=>'required',
            'preco'=> 'required|numeric',
            'quantidade'=> 'required|numeric',
        ]);


        Produto::create($request->all());


        return redirect()->route('produtos.index')
            ->with('success', 'produto criado com sucesso.');
    }


    public function show(Produto $produto)
    {
        return view('produtos.show', compact('produto'));
    }


    public function edit(Produto $produto)
    {
        return view('produto.edit', compact('produto'));
    }


    public function update(Request $request, Produto $produto)
    {
        $request->validate([
            'nome'=>'required|string|max:255',
            'descricao'=>'required',
            'preco'=> 'required|numeric',
            'quantidade'=> 'required|numeric',

        ]);
        $produto->update($request->all());
        return redirect()->route('produtos.index')
            ->with('success', 'produto atualizado com sucesso.');
    }


    public function destroy(Produto $produto)
    {
        $produto->delete();


        return redirect()->route('produtos.index')
            ->with('success', 'Produto Deletado com Sucesso.');
    }
}
