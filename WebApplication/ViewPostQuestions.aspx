<%@ Page Title="" Language="vb" AutoEventWireup="false" MasterPageFile="~/Site2.Master" CodeBehind="ViewPostQuestions.aspx.vb" Inherits="WebApplication1.WebForm8" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="conMain" runat="server">
     <h3 style="color: blue">View Post questions</h3>
    <p>Correct Answer is in bold</p>
    <center>
        <asp:Table ID="Table1" Width="80%" GridLines="Both" runat="server">
            <asp:TableRow runat="server">
                <asp:TableCell runat="server" CssClass="th1">Sno</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Title</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Option 1</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Option 2</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Option 3</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Option 4</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Edit</asp:TableCell>
                <asp:TableCell runat="server" CssClass="th1">Delete</asp:TableCell>
            </asp:TableRow>
        </asp:Table>
    </center>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHoldelast" runat="server">
</asp:Content>
